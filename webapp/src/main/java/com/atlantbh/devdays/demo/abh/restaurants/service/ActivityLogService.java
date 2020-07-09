package com.atlantbh.devdays.demo.abh.restaurants.service;

import com.atlantbh.devdays.demo.abh.restaurants.domain.ActivityLog;
import com.atlantbh.devdays.demo.abh.restaurants.repository.ActivityLogRepository;
import com.atlantbh.devdays.demo.abh.restaurants.service.requests.ActivityLogRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Service
public class ActivityLogService extends BaseCrudService<ActivityLog, Long, ActivityLogRepository> {
  private static final String DEFAULT_SORT_PROPERTY = "id";

  /**
   * Instantiates a new Base crud service.
   *
   * @param repository the repository
   */
  public ActivityLogService(ActivityLogRepository repository) {
    super(repository);
  }

  @Override
  public Page<ActivityLog> findAll(Pageable pageable) {
    return super.findAll(pageable, DEFAULT_SORT_PROPERTY, Sort.Direction.ASC);
  }

  /**
   * Creates a new city given a city request.
   *
   * @param request Request for creation containing all attributes for creation.
   * @return Newly created city.
   */
  public ActivityLog create(ActivityLogRequest request) {
    ActivityLog al = new ActivityLog();

    al.setAction(request.getAction());
    al.setCreatedAt((new java.sql.Timestamp(new java.util.Date().getTime())).toString());
    al.setUser(request.getUser());

    return repository.save(al);
  }
}
