package com.github.edurbs.cleanstock.slices.product.ui;

import com.github.edurbs.cleanstock.core.mainview.MainView;
import com.github.edurbs.cleanstock.slices.product.Product;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "products", layout = MainView.class)
@ViewController(id = "Product.list")
@ViewDescriptor(path = "product-list-view.xml")
@LookupComponent("productsDataGrid")
@DialogMode(width = "64em")
public class ProductListView extends StandardListView<Product> {
}