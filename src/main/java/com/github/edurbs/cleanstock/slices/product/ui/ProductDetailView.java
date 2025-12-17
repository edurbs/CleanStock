package com.github.edurbs.cleanstock.slices.product.ui;

import com.github.edurbs.cleanstock.core.mainview.MainView;
import com.github.edurbs.cleanstock.slices.product.Product;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "products/:id", layout = MainView.class)
@ViewController(id = "Product.detail")
@ViewDescriptor(path = "product-detail-view.xml")
@EditedEntityContainer("productDc")
public class ProductDetailView extends StandardDetailView<Product> {
}