import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | activity-log', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:activity-log');
    assert.ok(route);
  });
});
