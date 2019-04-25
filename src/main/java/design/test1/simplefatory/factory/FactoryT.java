package design.test1.simplefatory.factory;

import design.test1.simplefatory.product.Product;

/**
 * @Auther: cjw
 * @Date: 2018/9/29 16:58
 * @Description:
 */
public class FactoryT {

    private Product product;

    public void product(){
        this.product.detail();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
