import { Directive, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appShow]'
})
export class ShowDirective {

  constructor(public viewContainerRef: ViewContainerRef) { }

}
