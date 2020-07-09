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
   /* Predicate pricePredicate=null;
    Predicate ratePredicate=null;
    Predicate cuisinePredicate=null;

   if (filter.getPrice()!=null)  pricePredicate=builder.equal(root.get("priceRange"), filter.getPrice());
   if (filter.getRating()!=null) ratePredicate=builder.equal(root.get("averageRating"), filter.getRating());
   //System.out.println( root.get("cuisines"));
    //if (filter.getCuisine()!=null) ratePredicate=builder.equal(root.get("cuisines"), filter.getCuisine());

    Predicate finalPredicate=builder.and(pricePredicate, ratePredicate);*/
 return null;
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
