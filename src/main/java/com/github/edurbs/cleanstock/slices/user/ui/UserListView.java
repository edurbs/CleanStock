package com.github.edurbs.cleanstock.slices.user.ui;

import com.github.edurbs.cleanstock.core.mainview.MainView;
import com.github.edurbs.cleanstock.slices.user.User;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "users", layout = MainView.class)
@ViewController(id = "User.list")
@ViewDescriptor(path = "user-list-view.xml")
@LookupComponent("usersDataGrid")
@DialogMode(width = "64em")
public class UserListView extends StandardListView<User> {
}