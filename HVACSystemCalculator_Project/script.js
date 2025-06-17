document.getElementById('hvacForm').addEventListener('submit', function (e) {
  e.preventDefault();

  const refrigerant = document.getElementById('refrigerant').value;
  const quantity = parseFloat(document.getElementById('quantity').value);
  const service = document.getElementById('service').value;

  const refrigerantPrices = {
    R22: 250,
    R410a: 150,
    R454b: 99,
    R32: 89,
  };

  const serviceCosts = {
    installation: 500,
    repair: 200,
    maintenance: 100,
  };

  if (isNaN(quantity) || quantity < 0) {
    document.getElementById('result').innerText = 'Please enter a valid quantity.';
    return;
  }

  const refrigerantCost = refrigerantPrices[refrigerant] * quantity;
  const serviceCost = serviceCosts[service];
  const total = refrigerantCost + serviceCost;

  document.getElementById('result').innerHTML =
    `<p><strong>Refrigerant:</strong> ${refrigerant}</p>
     <p><strong>Quantity:</strong> ${quantity} lbs</p>
     <p><strong>Refrigerant Cost:</strong> $${refrigerantCost.toFixed(2)}</p>
     <p><strong>Service:</strong> ${service}</p>
     <p><strong>Service Cost:</strong> $${serviceCost.toFixed(2)}</p>
     <p><strong>Total Cost:</strong> $${total.toFixed(2)}</p>`;
});
