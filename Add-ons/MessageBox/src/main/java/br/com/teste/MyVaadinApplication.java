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


import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;
import de.steinwedel.vaadin.MessageBox;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application
{
    private Window window;
  private static final long serialVersionUID = -3764012561397333733L;
  private MessageBox mgberr, mgbquest, mgbinf, mgbnone, mgbwarn;
  private Button infomacao, erro, none, question, warn;

  @Override
  public void init() {

    final Window mainWindow = new Window("Sampleinvientchart2 Application");
    mainWindow.setSizeFull();
    setMainWindow(mainWindow);

    mgberr = new MessageBox(getMainWindow(),
            "My message ERRO...",
            MessageBox.Icon.ERROR,
            "Hello World!",
            new MessageBox.ButtonConfig(MessageBox.ButtonType.OK, "Ok"));

    mgbinf = new MessageBox(getMainWindow(),
            "My message INFO...",
            MessageBox.Icon.INFO,
            "Hello World!",
            new MessageBox.ButtonConfig(MessageBox.ButtonType.OK, "Ok"));

    mgbquest = new MessageBox(getMainWindow(),
            "My message QUESTION...",
            MessageBox.Icon.QUESTION,
            "Hello World!",
            new MessageBox.ButtonConfig(MessageBox.ButtonType.YES, "YES"),
            new MessageBox.ButtonConfig(MessageBox.ButtonType.NO, "NO"));

    mgbnone = new MessageBox(getMainWindow(),
            "My message NONE...",
            MessageBox.Icon.QUESTION,
            "Hello World!",
            new MessageBox.ButtonConfig(MessageBox.ButtonType.OK, "Ok"));

    mgbwarn = new MessageBox(getMainWindow(),
            "My message WARN...",
            MessageBox.Icon.WARN,
            "Hello World!",
            new MessageBox.ButtonConfig(MessageBox.ButtonType.OK, "Ok"));

    infomacao = new Button("Informação");

    infomacao.addListener(new Button.ClickListener() {

      public void buttonClick(ClickEvent event) {
        mgbinf.show(new MessageBox.EventListener() {

          public void buttonClicked(MessageBox.ButtonType buttonType) {
          }
        });
      }
    });

    erro = new Button("Erro");

    erro.addListener(new Button.ClickListener() {

      public void buttonClick(ClickEvent event) {
        mgberr.show(new MessageBox.EventListener() {

          public void buttonClicked(MessageBox.ButtonType buttonType) {
            System.out.println("Este botão foi pressionado: " + buttonType);
          }
        });
      }
    });

    none = new Button("None");

    none.addListener(new Button.ClickListener() {

      public void buttonClick(ClickEvent event) {
        mgbnone.show(new MessageBox.EventListener() {

          public void buttonClicked(MessageBox.ButtonType buttonType) {
            System.out.println("Este botão foi pressionado: " + buttonType);
          }
        });
      }
    });

    question = new Button("Question");

    question.addListener(new Button.ClickListener() {

      public void buttonClick(ClickEvent event) {
        mgbquest.show(new MessageBox.EventListener() {

          public void buttonClicked(MessageBox.ButtonType buttonType) {
            if (buttonType.toString().equals("YES")) {
              mainWindow.open(new ExternalResource("http://10.171.0.9:8080/bic/"));
              System.out.println("Este botão foi pressionado: " + buttonType);
            } else if (buttonType.toString().equals("NO")) {
              mainWindow.open(new ExternalResource("http://localhost:8080/modelo/"));
            }
          }
        });
      }
    });

    warn = new Button("Warn");

    warn.addListener(new Button.ClickListener() {

      public void buttonClick(ClickEvent event) {
        mgbwarn.show(new MessageBox.EventListener() {

          public void buttonClicked(MessageBox.ButtonType buttonType) {
            System.out.println("Este botão foi pressionado: " + buttonType);
          }
        });
      }
    });

    HorizontalLayout botao = new HorizontalLayout();
    botao.setSpacing(true);
    botao.addComponent(erro);
    botao.addComponent(warn);
    botao.addComponent(none);
    botao.addComponent(infomacao);
    botao.addComponent(question);

    // CustomDateField df = new CustomDateField();
    //df.setbTwelveHourClock(false);
    // df.setbTwelveHourClock(true);
    // mainWindow.addComponent(df);
    //mainWindow.addComponent(new WidgetSetTest());

    mainWindow.addComponent(botao);



  }
    
}
