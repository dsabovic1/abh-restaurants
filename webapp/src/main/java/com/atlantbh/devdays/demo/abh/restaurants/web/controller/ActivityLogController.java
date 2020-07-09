package com.atlantbh.devdays.demo.abh.restaurants.web.controller;

import com.atlantbh.devdays.demo.abh.restaurants.domain.ActivityLog;
import com.atlantbh.devdays.demo.abh.restaurants.repository.ActivityLogRepository;
import com.atlantbh.devdays.demo.abh.restaurants.service.ActivityLogService;
import com.atlantbh.devdays.demo.abh.restaurants.service.requests.ActivityLogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/activitylogs")
public class ActivityLogController
    extends BaseController<ActivityLogService, ActivityLogRepository, ActivityLog> {

  @Autowired
  public ActivityLogController(ActivityLogService service) {
    super(service);
  }

  @Transactional
  @PostMapping
  public ActivityLog create(@RequestBody ActivityLogRequest request) {
    return service.create(request);
  }
}
