var $usernameFld
var $passwordFld
var $firstNameFld
var $lastNameFld
var $roleFld
var $createBtn
var addUserBtn
var theTableBody
var user
var users=[]
var $deleteBtn
var userService= new UserServiceClient()
var $updateBtn

function createUser(user){
    userService.createUser(user)
        .then(function(actualUser){
            users.push(actualUser)
            renderUsers(users)
        })


}

var selectedUser =null
function selectUser(event){

    var selectBtn = jQuery(event.target)
    var theId = selectBtn.attr("id")
    selectedUser = users.find(user => user._id ===  theId)
    $usernameFld.val(selectedUser.Username)
    $firstNameFld.val(selectedUser.firstName)
    $lastNameFld.val(selectedUser.lastName)
    $roleFld.val(selectedUser.role)
}

function deleteUser(event) {

    console.log(event.target)
    var deleteBtn= jQuery(event.target)
    var theClass=deleteBtn.attr("class")
    console.log(theClass)

    var theIndex=deleteBtn.attr("id")
    var theId= users[theIndex]._id
    console.log(theId)

    userService.deleteUser(theId)
        .then(function(status){
            users.splice(theIndex, 1)
            renderUsers(users)
        })

}


function renderUsers(users){
    theTableBody.empty()
for( var i=0; i<users.length; i++) {
    var user =user=users[i];
    theTableBody.prepend(
        `<tr>
            <td>${user.Username}</td>
            <td>&nbsp;</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.role}</td>
            <td class="wbdv-actions">
        <span class="pull-right" style="white-space: nowrap">
             <i>&nbsp;</i>
             <i>&nbsp;</i>
             <i>&nbsp;</i>
             <i>&nbsp;</i>
             <i>&nbsp;</i>
          <i class="fa-2x fa fa-times wbdv-remove" id="${i}"></i>
          <i class="fa-2x fa fa-pencil wbdv-edit" id="${user._id}"></i>
        </span>
            </td>
        </tr>`)
}
    jQuery(".wbdv-remove")
        .click(deleteUser)
    jQuery(".wbdv-edit")
        .click(selectUser)
}


function updateUser(){
    console.log(selectedUser)
    selectedUser.Username = $usernameFld.val()
    selectedUser.firstName = $firstNameFld.val()
    selectedUser.lastName = $lastNameFld.val()
    selectedUser.role = $roleFld.val()
    userService.updateUser(selectedUser._id, selectedUser)
        .then(function (status){
         var index= users.findIndex(user => user._id === selectedUser._id)
            users[index] = selectedUser
            renderUsers(users)
        })
}

function init() {
    $usernameFld = $(".wbdv-username-fld")
    $passwordFld = $(".wbdv-password-fld")
    $firstNameFld = $(".wbdv-firstName-fld")
    $lastNameFld = $(".wbdv-lastName-fld")
    $roleFld = $(".wbdv-role-fld")
    $createBtn = $(".wbdv-create")
    $deleteBtn = $(".wbdv-remove")
    $updateBtn=$(".wbdv-update")
    theTableBody = jQuery('tbody')

    $updateBtn.click(updateUser)

    $createBtn.click(() => {
            createUser({
                Username: $usernameFld.val(),
                password: $passwordFld.val(),
                firstName: $firstNameFld.val(),
                lastName: $lastNameFld.val(),
                role: $roleFld.val()
            })

            $usernameFld.val("")
            $passwordFld.val("")
            $firstNameFld.val("")
            $lastNameFld.val("")
        }
    )

    userService.findAllUsers()
        .then(function (actualUsersFromServer) {
         users=actualUsersFromServer
            renderUsers(users)

        })
}
jQuery(init)







