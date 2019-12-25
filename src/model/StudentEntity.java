package model;

import javax.persistence.*;
import java.util.Objects;

/*
 *   #auther:李琪
 *   #date: 2019/12/18
 *   #description
 */
@Entity
@Table(name = "student", schema = "db_tb", catalog = "")
public class StudentEntity {
    private int id;
    private String username;
    private String password;
    private String name;

    public StudentEntity() {
    }
    public StudentEntity(int id,String username,String password,String name) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.name=name;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
