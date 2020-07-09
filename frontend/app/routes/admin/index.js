import Route from "@ember/routing/route";
import { inject as service } from "@ember/service";
import { hash } from "rsvp";

export default Route.extend({
  restaurantService: service("restaurant-service"),
  cuisineService: service("cuisine-service"),
  locationService: service("location-service"),
  userService: service("user-service"),
  queryParams: {
    page: {
      refreshModel: true,
    },
  },

  model(params) {
    return hash({
      restaurants: this.get("restaurantService")
        .findAllRestaurants({
          page: params.page,
        })
        .then((results) => {
          return results.totalElements;
        }),
      cuisines: this.get("cuisineService")
        .fetchAllCuisines({
          page: params.page,
        })
        .then((results) => {
          return results.totalElements;
        }),
      locations: this.get("locationService")
        .getAllCities({
          page: params.page,
        })
        .then((results) => {
          return results.totalElements;
        }),
      users: this.get("userService")
        .filter({
          page: params.page,
        })
        .then((results) => {
          return results.totalElements;
        }),
    });
  },
});
