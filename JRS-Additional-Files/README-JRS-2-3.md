# JRS
## JRS2
```json
[
  {
    "id": 1,
    "name": "Schusterjunge",
    "price": 0,
    "expirationAfterStocked": 720,
    "productType": "ROLL"
  },
  {
    "id": 3,
    "name": "Kirschplunder",
    "price": 0,
    "expirationAfterStocked": 1080,
    "productType": "PASTRY"
  }
]
```
## JRS3
> Was hat sich strukturell an der Repräsentation der Daten geändert?
- Verweis auf Klasse
- (Bundle existieren)
```json
[
  {
    "@class": "org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem",
    "productType": "ROLL",
    "expirationAfterStocked": 720,
    "id": 1,
    "name": "Schusterjunge",
    "price": 0
  },
  {
    "@class": "org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem",
    "productType": "PASTRY",
    "expirationAfterStocked": 1080,
    "id": 3,
    "name": "Kirschplunder",
    "price": 0
  },
  {
    "@class": "org.dieschnittstelle.ess.entities.erp.Campaign",
    "bundles": [
      {
        "id": 0,
        "product": {
          "@class": "org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem",
          "productType": "ROLL",
          "expirationAfterStocked": 720,
          "id": 2,
          "name": "Schrippe Schrippe",
          "price": 0
        },
        "units": 10
      },
      {
        "id": 0,
        "product": {
          "@class": "org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem",
          "productType": "PASTRY",
          "expirationAfterStocked": 1080,
          "id": 3,
          "name": "Kirschplunder",
          "price": 0
        },
        "units": 3
      }
    ],
    "id": 4,
    "price": 0
  }
]
```
