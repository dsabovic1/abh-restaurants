package com.atlantbh.devdays.demo.abh.restaurants.repository.specification;

import com.atlantbh.devdays.demo.abh.restaurants.domain.Restaurant;
import com.atlantbh.devdays.demo.abh.restaurants.service.requests.RestaurantFilter;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/** Restaurant filter specification. */
public class RestaurantSpecification implements Specification<Restaurant> {
  private RestaurantFilter filter;

  /**
   * Instantiates a new restaurant specification.
   *
   * @param filter Filter.
   */
  public RestaurantSpecification(RestaurantFilter filter) {
    this.filter = filter;
  }

  @Override
  public Predicate toPredicate(
      Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

      Predicate pricePredicate=null;
    Predicate ratePredicate=null;
    Predicate namePredicate=null;

    Long rating= Long.valueOf(0);




   if(filter.getPrice()!=null && filter.getRating()!=null) {
       pricePredicate=builder.equal(root.get("priceRange"), filter.getPrice());
       rating=filter.getRating();
       ratePredicate=builder.equal(root.get("averageRating"), rating);
       if (filter.getName()!=null && !filter.getName().isEmpty()) {
           namePredicate = builder.equal(root.get("name"), filter.getName());
           return builder.and(pricePredicate, ratePredicate, namePredicate);
       }
       return builder.and(pricePredicate, ratePredicate);
   }
   else if (filter.getPrice()!=null) {
       pricePredicate=builder.equal(root.get("priceRange"), filter.getPrice());
       if (filter.getName()!=null && !filter.getName().isEmpty()) {
           namePredicate = builder.equal(root.get("name"), filter.getName());
           return builder.and(pricePredicate, namePredicate);
       }
       return pricePredicate;
   }
   else if (filter.getRating()!=null) {
       rating=filter.getRating();
       ratePredicate=builder.equal(root.get("averageRating"), rating);
       if (filter.getName()!=null && !filter.getName().isEmpty()) {
           namePredicate = builder.equal(root.get("name"), filter.getName());
           return builder.and(ratePredicate, namePredicate);
       }
       return ratePredicate;
   }
   else {
       if (filter.getName()!=null && !filter.getName().isEmpty()) {
           namePredicate = builder.equal(root.get("name"), filter.getName());
           return namePredicate;
       }
       else return null;
   }

  }

  /**
   * Create a page object from filter.
   *
   * @param filter Filter.
   * @return Page object.
   */
  public static Pageable createPage(RestaurantFilter filter) {
    RestaurantFilter.Sort sortProperty = filter.getSortBy();
    return PageRequest.of(
        filter.getPage(),
        filter.getPageSize(),
        sortProperty.getDirection(),
        sortProperty.getPropertyName());
  }
}
