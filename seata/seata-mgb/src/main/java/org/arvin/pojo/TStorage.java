package org.arvin.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author arvin
 * @since 2023-03-21
 */
@TableName("t_storage")
public class TStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer productId;

    private Integer total;

    private Integer used;

    private Integer residue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }

    @Override
    public String toString() {
        return "TStorage{" +
        "id = " + id +
        ", productId = " + productId +
        ", total = " + total +
        ", used = " + used +
        ", residue = " + residue +
        "}";
    }
}
