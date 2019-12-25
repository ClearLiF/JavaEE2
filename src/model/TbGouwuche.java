package model;

import javax.persistence.*;
import java.util.Objects;

/*
 *   #auther:李琪
 *   #date: 2019/12/20
 *   #description
 */
@Entity
@Table(name = "tb_gouwuche", schema = "db_tb", catalog = "")
public class TbGouwuche {
    private int id;
    private int spid;

    private int num;
    private String addtime;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    @Column(name = "spid")
    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }



    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "addtime")
    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbGouwuche that = (TbGouwuche) o;
        return id == that.id &&
                spid == that.spid &&
                num == that.num &&
                Objects.equals(addtime, that.addtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spid, num, addtime);
    }
}
