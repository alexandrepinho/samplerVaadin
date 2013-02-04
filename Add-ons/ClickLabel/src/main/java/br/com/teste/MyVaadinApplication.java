/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.teste;

import com.google.gwt.user.client.ui.ImageBundle;
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Window;
import org.vaadin.addons.mspapant.clickableLabel.ClickableLabel;
import org.vaadin.addons.mspapant.clickableLabel.widgetset.client.ui.VClickableLabel;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {

  private static final ThemeResource icon = new ThemeResource("../icone/pdf.png");
  private Window window;

  @Override
  public void init() {
    setTheme("runo");
    
    window = new Window("My Vaadin Application");
    setMainWindow(window);

    ClickableLabel clickableLabel = new ClickableLabel();
    clickableLabel.setIcon(icon);
    clickableLabel.setStyleName("css_8");

    clickableLabel.addListener(new Button.ClickListener() {

      @Override
      public void buttonClick(Button.ClickEvent event) {
   
        getMainWindow().showNotification("Hello Button.");

      }
    });

    window.addComponent(clickableLabel);

  }
}
