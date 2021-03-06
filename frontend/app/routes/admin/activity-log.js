import Route from "@ember/routing/route";

import { inject as service } from "@ember/service";
import { hash } from "rsvp";

export default Route.extend({
  activitylogsService: service("activitylogs-service"),

  queryParams: {
    page: {
      refreshModel: true,
    },
  },

  model() {
    return hash({
      activitylogs: this.get("activitylogsService")
        .fetchAllLogs({})
        .then((results) => {
          console.log(results);
          return results;
        }),
    });
  },
});
