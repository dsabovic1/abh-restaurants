import Controller from "@ember/controller";
import { inject as service } from "@ember/service";

export default Controller.extend({
  userService: service("user-service"),
  activitylogsService: service("activitylogs-service"),

  actions: {
    onRegister({ firstName, lastName, email, password, address, phone }) {
      const userRequest = {
        firstName,
        lastName,
        email,
        password,
        address,
        phone,
      };
      this.get("activitylogsService").create({
        user: firstName + " " + lastName,
        action: "New user " + firstName + " " + lastName + " registered",
      });
      return this.get("userService")
        .register(userRequest)
        .then(() => {
          return this.get("userService")
            .login(email, password)
            .then(() => window.location.reload());
        })
        .catch((error) => {
          return {
            hasError: true,
            errorMessage: error.payload.message,
          };
        });
    },
  },
});
