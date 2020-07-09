import Controller from "@ember/controller";
import { inject as service } from "@ember/service";

export default Controller.extend({
  activitylogsService: service("activitylogs-service"),

  queryParams: {
    page: {
      refreshModel: true,
    },
  },

  actions: {
    onNewLog(params) {
      this.get("activitylogsService")
        .create({
          params,
        })
        .then((results) => {
          console.log(results);
        });
    },
  },
});
