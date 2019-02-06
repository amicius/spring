package fr.dta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.dta.persistence.IoEntity;

@Entity
@Table( name = "user_" )
@SequenceGenerator( name = "user_seq" )
public class User implements IoEntity {

    private static final long serialVersionUID = -4770652619146976213L;
    
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "user_seq" )
    private Long              id;
    @Column
    @NotNull
    private String            login;
    @Column
    @NotNull
    private String            password;
    @Column
    private String            nom;

    @Override
    public Long getId() {

        return this.id;
    }

    @Override
    public void setId( Long id ) {

    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public User() {
        super();
    }
    
    public User( String login, String password, String nom ) {
        super();
        this.login = login;
        this.password = password;
        this.nom = nom;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        User other = (User) obj;
        if ( id == null ) {
            if ( other.id != null )
                return false;
        } else if ( !id.equals( other.id ) )
            return false;
        return true;
    }
  
}
