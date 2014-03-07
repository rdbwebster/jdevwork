This app is a customer BPMN 11.1.1.1 demo that compliments the OEP demo provided by lloyd williams. LLoyd's demo is an eclipse OEP project that allows a user to add snacks to a shopping cart.  When a certain dollar threshold is exceeded an offer for more snacks is presented in the browser.

This app is a somewhat contrived BPM scenario that polls the customer DB used by lloyds demo to start a BPM process if the customers total purchases hit a certain threshold.  The BPM process calls a web service named getCustomerPreferences (see the corresponding eclipse shopping project in git) that returns the communications restrictions the customer has requested.

If the customer comm is not restricted then a email is sent to the customer telling them their status is changed.  If the account is restricted (determined by rules engine) then a human workflow is invoked to review the settings and see if there is some way the customer can be contacted.

In the initial release of this demo lloyds app does not really update the total purchases in the db. so a script needs to update the db so that the bpm polling process will pick the record. 
There are not real links between the demos other that the existence of the db.
Lloyds original schema in updated to add a few fields like total field
