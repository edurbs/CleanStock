package com.github.edurbs.cleanstock.slices.person.ui;

import com.github.edurbs.cleanstock.core.mainview.MainView;
import com.github.edurbs.cleanstock.slices.person.Consumer;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "consumers/:id", layout = MainView.class)
@ViewController(id = "Consumer.detail")
@ViewDescriptor(path = "consumer-detail-view.xml")
@EditedEntityContainer("consumerDc")
public class ConsumerDetailView extends AbstractPersonDetailView<Consumer> {
}
