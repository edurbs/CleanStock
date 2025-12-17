package com.github.edurbs.cleanstock.slices.person.ui;

import com.github.edurbs.cleanstock.core.mainview.MainView;
import com.github.edurbs.cleanstock.slices.person.Supplier;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "suppliers", layout = MainView.class)
@ViewController(id = "Supplier.list")
@ViewDescriptor(path = "supplier-list-view.xml")
@LookupComponent("suppliersDataGrid")
@DialogMode(width = "64em")
public class SupplierListView extends StandardListView<Supplier> {
}