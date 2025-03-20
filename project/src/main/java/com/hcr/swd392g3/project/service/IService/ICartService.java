package com.hcr.swd392g3.project.service.IService;

import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Cart;

public interface ICartService {
	Cart addToCart(Cart cart);
	Cart updateCart(Cart cart);
	void delete(int  id);
}
