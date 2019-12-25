package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/*
 *   #auther:李琪
 *   #date: 2019/12/21
 *   #description
 */
@Entity
@Table(name = "tb_type2", schema = "db_tb", catalog = "")
public class TbType2 {
    private int id;
    private String typename;
    private TbType tbTypeByTypeid;


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
        TbType2 tbType2 = (TbType2) o;
        return id == tbType2.id &&
                Objects.equals(typename, tbType2.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typename);
    }

    @ManyToOne
    @JoinColumn(name = "typeid", referencedColumnName = "id", nullable = false)
    public TbType getTbTypeByTypeid() {
        return tbTypeByTypeid;
    }

    public void setTbTypeByTypeid(TbType tbTypeByTypeid) {
        this.tbTypeByTypeid = tbTypeByTypeid;
    }


}
