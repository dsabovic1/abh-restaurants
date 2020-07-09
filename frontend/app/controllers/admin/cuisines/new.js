import Controller from "@ember/controller";
import { inject as service } from "@ember/service";

export default Controller.extend({
  cuisineService: service("cuisine-service"),
  activitylogsService: service("activitylogs-service"),

  actions: {
    onSubmitCuisine() {
      const id = this.get("model.cuisine.id");
      const isCreating = typeof id === "undefined";
      let cuisineName = this.get("model.cuisine.name");
      let promise;

      if (isCreating) {
        promise = this.get("cuisineService").create(this.get("model.cuisine"));
        this.get("activitylogsService").create({
          user: "Admin",
          action: cuisineName + " cuisine created",
        });
      } else {
        promise = this.get("cuisineService").update(
          id,
          this.get("model.cuisine")
        );
        this.get("activitylogsService").create({
          user: "Admin",
          action: "Cuisine " + cuisineName + " updated",
        });
      }

      promise.then(() => this.transitionToRoute("admin.cuisines"));
    },
  },
});
