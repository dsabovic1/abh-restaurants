import Route from "@ember/routing/route";
import { inject as service } from "@ember/service";
import { hash } from "rsvp";

export default Route.extend({
  restaurantService: service("restaurant-service"),

  queryParams: {
    restaurantName: {
      refreshModel: true,
    },
    numberOfPeople: {
      refreshModel: true,
    },
    time: {
      refreshModel: true,
    },
    page: {
      refreshModel: true,
    },
  },

  model(params) {
    return hash({
      restaurants: this.get("restaurantService")
        .findAllRestaurants({
          page: params.page,
          name: params.restaurantName,
        })
        .then((results) => {
          let res = [];
          results.content.forEach((element) => {
            if (element.name == params.restaurantName) {
              res.push(element);
            }
          });
          console.log(res);
          results.content = res;
          console.log(results);
          return results;
        }),
    });
  },
});
