import { TestBed } from '@angular/core/testing';

import { CanVisitService } from './can-visit.service';

describe('CanVisitService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CanVisitService = TestBed.get(CanVisitService);
    expect(service).toBeTruthy();
  });
});
