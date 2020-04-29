import { TestBed } from '@angular/core/testing';

import { ZooserviceService } from './zooservice.service';

describe('ZooserviceService', () => {
  let service: ZooserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZooserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
