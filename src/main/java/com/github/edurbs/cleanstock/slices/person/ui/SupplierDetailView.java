package com.github.edurbs.cleanstock.slices.person.ui;

import com.github.edurbs.cleanstock.core.mainview.MainView;
import com.github.edurbs.cleanstock.slices.person.Supplier;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "suppliers/:id", layout = MainView.class)
@ViewController(id = "Supplier.detail")
@ViewDescriptor(path = "supplier-detail-view.xml")
@EditedEntityContainer("supplierDc")
public class SupplierDetailView extends AbstractPersonDetailView<Supplier> {
}
