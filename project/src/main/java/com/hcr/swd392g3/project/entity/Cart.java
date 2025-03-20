package com.hcr.swd392g3.project.entity;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public Cart(ArrayList<CartItem> items) {
		this.items = items;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}

	public CartItem getItemById(int id) {
		for (CartItem i : items) {
			if (i.getMenuDTO().getMenuID()== id) {
				return i;
			}
		}
		return null;
	}

	//tra ve so luong khi biet id
	public int getQuantityById(int id) {
		
		return getItemById(id).getQuantity();
	}
	
	public void setQuantityById(int id, int quantity) {
		
		getItemById(id).setQuantity(quantity);
	}


	



    //them 1 san pham vao gio hang
    public void addItem(CartItem item) {
        //co trong gio roi
        if (getItemById(item.getMenuDTO().getMenuID()) != null) {
            //lay tu gio hang ra
            CartItem i = getItemById(item.getMenuDTO().getMenuID());
            i.setQuantity(i.getQuantity() + item.getQuantity());
        } else {
            //chua co thi add vao gio
            boolean add = items.add(item);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (CartItem i : items) {
            t += i.getQuantity() * i.getPrice();
        }
        return t;
    }
	/*private List<CartItem> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public Cart(List<CartItem> items) {
		this.items = items;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	private CartItem getItemById(int id) {
		for (CartItem i : items) {
			if (i.getMenu().getMenuID()== id) {
				return i;
			}
		}
		return null;
	}

	//tra ve so luong khi biet id
	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}

	//them 1 san pham vao gio hang
	public void addItem(CartItem t) {
		//co trong gio roi
		if (getItemById(t.getMenu().getMenuID()) != null) {
			//lay tu gio hang ra
			CartItem i = getItemById(t.getMenu().getMenuID());
			i.setQuantity(i.getQuantity() + t.getQuantity());
		} else {
			//chua co thi add vao gio
			items.add(t);
		}
	}

	public void removeItem(int id) {
		if (getItemById(id) != null) {
			items.remove(getItemById(id));
		}
	}

	public double getTotalMoney() {
		double t = 0;
		for (CartItem i : items) {
			t += i.getQuantity() * i.getPrice();
		}
		return t;
	}
	*/

}