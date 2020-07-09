import BaseService from "./base-service";

export default BaseService.extend({
  fetchAllLogs() {
    return this.get("/api/v1/activitylogs");
  },

  create(request) {
    return this.post("/api/v1/activitylogs", request);
  },
});
