package com.example.wbdvsp2101ishitajavaserver.services;
import com.example.wbdvsp2101ishitajavaserver.models.Widget;
import com.example.wbdvsp2101ishitajavaserver.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;
   /*private List<Widget> widgets = new ArrayList<Widget>();
    {
        Widget w1 = new Widget(123l, "6049bf2e27a5f00017073793", "HEADING", 1, "Welcome to Widgets");
        Widget w2 = new Widget(234l, "ABC234", "PARAGRAPH", 1, "This is a paragraph");
        Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Welcome to WebDev");
        Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Lorem ipsum");
        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
        widgets.add(w4);
    }*/

    // implement crud operations
    public Widget createWidgetForTopic(Widget widget) {
        return repository.save(widget);
       /* Long id = (new Date()).getTime();
        widget.setId(id);
        widgets.add(widget);
        return widget;*/
    }

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }
    public List<Widget> findWidgetsForTopic(String topicId) {

        return repository.findWidgetsForTopic(topicId);
        /*List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(topicId)) {
                ws.add(w);
            }
        }
        return ws;*/
    }
    public Widget findWidgetById(Long id) {
        return repository.findWidgetById(id);
        /*for(Widget w: widgets) {
            if(w.getId().equals(id)) {
                return w;
            }
        }
        return null;*/
    }
    public Integer updateWidget(Long id, Widget newWidget) {

        Widget originalWidget =findWidgetById(id);
        originalWidget.setText(newWidget.getText());
        originalWidget.setSrc(newWidget.getSrc());
        originalWidget.setHeight(newWidget.getHeight());
        originalWidget.setWidth(newWidget.getWidth());
        originalWidget.setSize(newWidget.getSize());
        originalWidget.setType(newWidget.getType());
        originalWidget.setOrdered(newWidget.getOrdered());

        repository.save(originalWidget);
        return 1;
       /* for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(id)) {
                widgets.set(i, newWidget);
                return 1;
            }
        }
        return -1;*/
    }
    public Integer deleteWidget(Long id) {

        repository.deleteById(id);
        return 1;
        /*int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(id)) {
                index = i;
            }
        }
        if(index >= 0) {
            widgets.remove(index);
            return 1;
        }
        return -1;*/
    }
}
