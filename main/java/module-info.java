module br.com.academico.sistema.sistemaacademico {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.desktop;
    requires java.base;
    requires mysql.connector.j;
    requires jakarta.transaction;
    requires  jakarta.cdi;

    opens br.com.academico.sistema.sistemaacademico to javafx.fxml;
    exports br.com.academico.sistema.sistemaacademico;

    exports br.com.academico.sistema.sistemaacademico.controllers;
    opens br.com.academico.sistema.sistemaacademico.controllers to javafx.fxml;

    opens br.com.academico.sistema.sistemaacademico.models to org.hibernate.orm.core;

    exports  br.com.academico.sistema.sistemaacademico.view;
    opens br.com.academico.sistema.sistemaacademico.view to javafx.fxml;





}