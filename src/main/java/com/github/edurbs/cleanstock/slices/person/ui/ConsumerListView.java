package com.github.edurbs.cleanstock.slices.person.ui;

import com.github.edurbs.cleanstock.core.mainview.MainView;
import com.github.edurbs.cleanstock.slices.person.Consumer;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "consumers", layout = MainView.class)
@ViewController(id = "Consumer.list")
@ViewDescriptor(path = "consumer-list-view.xml")
@LookupComponent("consumersDataGrid")
@DialogMode(width = "64em")
public class ConsumerListView extends StandardListView<Consumer> {
}