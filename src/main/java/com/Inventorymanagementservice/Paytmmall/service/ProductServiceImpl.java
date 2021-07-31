package com.Inventorymanagementservice.Paytmmall.service;

import com.Inventorymanagementservice.Paytmmall.converter.ConvertForDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDto;
import com.Inventorymanagementservice.Paytmmall.dto.ProductDtoExtension;
import com.Inventorymanagementservice.Paytmmall.exception.ProductNotFoundException;
import com.Inventorymanagementservice.Paytmmall.exception.QuantityNotGreaterThanZeroException;
import com.Inventorymanagementservice.Paytmmall.entity.Product;
import com.Inventorymanagementservice.Paytmmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;
    private ConvertForDto convertForDto;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ConvertForDto convertForDto)
    {
        this.productRepository = productRepository;
        this.convertForDto = convertForDto;
    }

    @Override
    public ProductDtoExtension saveProductDetail(ProductDto productDto)
    {
        Product product = convertForDto.productDtoToProduct(productDto);

        product = productRepository.save(product);
        return convertForDto.productToProductDtoExtension(product);
    }

    @Override
    public List<ProductDtoExtension> getAllProductDetail() {
        List<Product>product =  productRepository.findAll();
        return convertForDto.productToProductDtoExtension(product);
    }



    @Override
    public ProductDto getProductDetailByProductId(String productId)
            throws ProductNotFoundException {
        Optional<Product> product = Optional.ofNullable(productRepository.findByproductId(productId));
        if(!product.isPresent())
        {
            throw new ProductNotFoundException("Product is not present");
        }

        return convertForDto.productToProductDto(product.get());
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @Override
    public ProductDto updateProductQuantityByDeletingItem(String productId, Long itemQuantity)
            throws QuantityNotGreaterThanZeroException, ProductNotFoundException {

        Optional<Product> product= Optional.ofNullable(productRepository.findByproductIdWithPessimisticLock(productId));
        if(!product.isPresent())
        {
            throw new ProductNotFoundException("product is missing whose item you want to add!!");
        }

        long currQuantity = product.get().getItemQuantity();

        long newQuantity = currQuantity - itemQuantity;

        if(newQuantity<0)
        {
            throw new QuantityNotGreaterThanZeroException("quantity in inventory is less than the quantity you want to Delete!!");
        }


        product.get().setItemQuantity(newQuantity);
        Product p = productRepository.save(product.get());
        return convertForDto.productToProductDto(p);
    }

    @Override
    public ProductDto updateProductQuantityByAddItem(String productId, Long itemQuantity) throws ProductNotFoundException {
        Optional<Product> product = Optional.ofNullable(productRepository.findByproductId(productId));
        if(!product.isPresent())
        {
            throw new ProductNotFoundException("product is missing whose item you want to add!!");
        }
        Long curr_Quantity = product.get().getItemQuantity();

        Long new_Quantity = curr_Quantity + itemQuantity;
        product.get().setItemQuantity(new_Quantity);

        Product p = productRepository.save(product.get());

        return convertForDto.productToProductDto(p);
    }


    @Override
    public ProductDtoExtension updateProductDetailByProductId(String productId, ProductDto productDto) {
        Product product = productRepository.findByproductId(productId);
        if(Objects.nonNull(productDto.getItemPrice()) &&
        !"".equalsIgnoreCase(String.valueOf(productDto.getItemPrice())))
        {
            product.setItemPrice(productDto.getItemPrice());
        }

        if(Objects.nonNull(productDto.getItemDescription()) &&
                !"".equalsIgnoreCase(productDto.getItemDescription()))
        {
            product.setItemDescription(productDto.getItemDescription());
        }

        if(Objects.nonNull(productDto.getItemName()) &&
                !"".equalsIgnoreCase(productDto.getItemName()))
        {
            product.setItemName(productDto.getItemName());
        }

        if(Objects.nonNull(productDto.getItemImageUrl()) &&
                !"".equalsIgnoreCase(productDto.getItemImageUrl()))
        {
            product.setItemImageUrl(productDto.getItemImageUrl());
        }

        Product p = productRepository.save(product);
        return convertForDto.productToProductDtoExtension(p);
    }


}



//    @Override
//    public ProductDto getProductDetailById(String productId) throws ProductNotFoundException {
//        Optional<Product> product = Optional.ofNullable(productRepository.findByproductId(productId));
//        if(!product.isPresent())
//        {
//            throw new ProductNotFoundException("Product is not present");
//        }
//
//        return convertForDto.productToProductDto(product.get());
//    }





































//
//package com.example.MoneyTransactionService.Service;
//
//        import static org.junit.jupiter.api.Assertions.*;
//
//        import java.math.BigDecimal;
//
//        import javax.transaction.Transactional;
//
//        import org.junit.jupiter.api.Test;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.boot.test.context.SpringBootTest;
//        import org.springframework.boot.test.context.TestConfiguration;
//        import org.springframework.context.annotation.Bean;
//
//        import com.example.MoneyTransactionService.Entity.Account;
//
//@SpringBootTest
//class AccountServiceImplTest {
//
//    @TestConfiguration
//    static class AccountServiceTestContextConfiguration {
//        @Bean
//        public AccountServiceImpl accountServiceImplTest() {
//            return new AccountServiceImpl();
//        }
//    }
//
//    @Autowired
//    private AccountServiceImpl accountService;
//
//    @Test
//    public void saveTest() {
//        Account account1 = new Account( "1701", new BigDecimal(50000));
//        accountService.save(account1);
//        BigDecimal bd1 =  accountService.findByAccountNumber(account1.getAccountNumber()).getCurrentBalance();
//        BigDecimal bd2 = new BigDecimal(50000);
//        assertEquals(bd1,bd2);
//    }
//
//    @Test
//    public void update() {
//        Account account1 = new Account( "1010", new BigDecimal(50000));
//        accountService.save(account1);
//
//        accountService.update(account1.getAccountNumber(), new BigDecimal(3000));
//        BigDecimal bd1 =  accountService.findByAccountNumber(account1.getAccountNumber()).getCurrentBalance();
//        BigDecimal bd2 = new BigDecimal(53000);
//        assertEquals(bd1,bd2);
//
//    }
//
//    @Test
//    public void sendMoneyTest() {
//
//        Account account1 = new Account( "1082", new BigDecimal(50000));
//        Account account2 = new Account( "2008", new BigDecimal(2000));
//        accountService.save(account1);
//        accountService.save(account2);
//
//
//      /*  TransferBalanceRequest transferBalanceRequest =
//                new TransferBalanceRequest(
//                        account1.getAccountNumber(),
//                        account2.getAccountNumber(),
//                        new BigDecimal(3000)
//                );*/
//        accountService.sendMoney( account1.getAccountNumber(),
//                account2.getAccountNumber(),
//                new BigDecimal(3000));
//      /*  assertThat(( accountService.findByAccountNumber(account1.getAccountNumber())
//                .getCurrentBalance())
//                .isEqualTo(new BigDecimal(47000)));*/
//        BigDecimal bd1 =  accountService.findByAccountNumber(account1.getAccountNumber()).getCurrentBalance();
//        BigDecimal bd2 = new BigDecimal(47000);
//        assertEquals(bd1,bd2);
//
//        BigDecimal bd3=  accountService.findByAccountNumber(account2.getAccountNumber()).getCurrentBalance();
//        BigDecimal bd4 = new BigDecimal(5000);
//
//        assertEquals(bd3,bd4);
//
//
//    }
//
//
//    @Test
//    public void getStatement() {
//
//        Account account1 = new Account( "1001", new BigDecimal(50000));
//        Account account2 = new Account( "2001", new BigDecimal(2000));
//        accountService.save(account1);
//        accountService.save(account2);
//     /*   TransferBalanceRequest transferBalanceRequest =
//                new TransferBalanceRequest(
//                        account1.getAccountNumber(),
//                        account2.getAccountNumber(),
//                        new BigDecimal(3000)
//                );*/
//
//        accountService.sendMoney( account1.getAccountNumber(),
//                account2.getAccountNumber(),
//                new BigDecimal(3000));
//        /*assertThat(accountService.getSimpleStatement(account1.getAccountNumber())
//                .getCurrentBalance())
//                .isEqualTo(new BigDecimal(47000));*/
//        BigDecimal bd5 = accountService.getSimpleStatement(account1.getAccountNumber()).getCurrentBalance();
//        BigDecimal bd6 = new BigDecimal(47000);
//        org.junit.Assert.assertEquals(bd5,bd6);
//
//        accountService.sendMoney( account1.getAccountNumber(),
//                account2.getAccountNumber(),
//                new BigDecimal(3000));
//        //assertThat(accountService.getSimpleStatement(account1.getAccountNumber())
//        //      .getCurrentBalance()).isEqualTo(new BigDecimal(44000));
//        BigDecimal bd7 = accountService.getSimpleStatement(account1.getAccountNumber()).getCurrentBalance();
//        BigDecimal bd8 = new BigDecimal(44000);
//        org.junit.Assert.assertEquals(bd7,bd8);
//
//        // assertThat(accountService.getSimpleStatement(account1.getAccountNumber())
//        //        .getTransactionHistory().size()).isEqualTo(2);
//
//        org.junit.Assert.assertEquals(accountService.getSimpleStatement(account1.getAccountNumber()).getTransactionHistory().size(),2);
//
//    }
//
//}
