package model;

import javax.persistence.*;
import java.util.*;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Entity
@Table(name = "tb_type", schema = "db_tb", catalog = "")
public class TbType {
    private int id;
    private String typename;
    private Set<TbType2> tbType2sById = new HashSet<>();

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typename")
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbType tbType = (TbType) o;
        return id == tbType.id &&
                Objects.equals(typename, tbType.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typename);
    }

    @OneToMany(mappedBy = "tbTypeByTypeid")
    public Set<TbType2> getTbType2sById() {
        return tbType2sById;
    }

    public void setTbType2sById(Set<TbType2> tbType2sById) {
        this.tbType2sById = tbType2sById;
    }
}
