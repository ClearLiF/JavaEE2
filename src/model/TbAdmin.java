package model;

import javax.persistence.*;
import java.util.Objects;

/*
 *   #auther:李琪
 *   #date: 2019/12/26
 *   #description
 */
@Entity
@Table(name = "tb_admin", schema = "db_tb", catalog = "")
public class TbAdmin {
    private int id;
    private String name;
    private String pwd;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAdmin tbAdmin = (TbAdmin) o;
        return id == tbAdmin.id &&
                Objects.equals(name, tbAdmin.name) &&
                Objects.equals(pwd, tbAdmin.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pwd);
    }

    @Override
    public String toString() {
        return "TbAdmin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
