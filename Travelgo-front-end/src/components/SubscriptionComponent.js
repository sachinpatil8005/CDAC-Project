// SubscriptionComponent.js
import React, { useState } from 'react';
import '../CSS/SubscriptionComponent.css';
import { Link } from 'react-router-dom';

const SubscriptionComponent = () => {
  const [selectedSubscription, setSelectedSubscription] = useState(null);
  const [selectedSubId, setSelectedSubId] = useState(null);

  const handleSubscriptionSelect = (subscriptionId, subId) => {
    setSelectedSubscription(subscriptionId);
    setSelectedSubId(subId);
  };

  const subscriptionData = [
     // Add sub data and select one from here mentioned
    { id_subscribtion: 1, amount: 1000, validity: 3, props: 3 },
    { id_subscribtion: 2, amount: 1500, validity: 6, props: 5 },
   
  ];

  const selectedSubscriptionData = subscriptionData.find(
    (sub) => sub.id_subscribtion === selectedSubscription
  );

  return (
    <div className="subscription-container">
      <div className="subscription-cards">
        {subscriptionData.map((sub) => (
          <div
            key={sub.id_subscribtion}
            className="subscription-card"
            onClick={() => handleSubscriptionSelect(sub.id_subscribtion, sub.id_subscribtion)}
            style={{ backgroundColor: selectedSubscription === sub.id_subscribtion ? '#f39c12' : 'white' }}
          >
            <h3>Subscription {sub.id_subscribtion}</h3>
            <p>Amount: Rupee{sub.amount}</p>
            <p>Validity: {sub.validity} Months</p>
          </div>
        ))}
      </div>

      {selectedSubId && (
        <Link className="btn btn-warning white px-3" to={`/host?sub_id=${selectedSubId}`}>
          <b>Proceed</b>
        </Link>
      )}
    </div>
  );
};

export default SubscriptionComponent;
