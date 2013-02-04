package br.com.teste;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import org.vaadin.teemu.switchui.Switch;

@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {

  private Window window;
  TextField t = new TextField("Teste");

  @Override
  public void init() {

    setTheme("runo");
    window = new Window("My Vaadin Application");
    setMainWindow(window);


    final Switch s = new Switch();
    s.setCaption("sim");

    s.addListener(new Property.ValueChangeListener() {

      public void valueChange(Property.ValueChangeEvent event) {
        getMainWindow().showNotification(event.getProperty().getValue().toString());
        System.out.println(event.getProperty().toString());
        if (event.getProperty().getValue().equals(true)) {
          System.out.println("Agora sim");

          window.addComponent(t);
        } else {
          System.out.println("Agora não");
          window.removeComponent(t);
        }
      }
    });
    s.setImmediate(true);



    window.addComponent(s);


  }
}
