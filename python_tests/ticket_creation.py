import unittest
import requests

class SwaggerAPITestCase(unittest.TestCase):

    def setUp(self):
        # Set up the base URL for your Swagger API
        self.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    
    def test_create_ticket_with_product_version_and_client(self):
        # Given product, version, and client
        payload = {
            "codigo": "TPG1",
            "titulo": "Github",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 3,
            "versionProducto": 1.0
        }

        # When trying to create the ticket
        response = requests.post(f'{self.base_url}/tickets', json=payload)

        # Then ticket is created
        self.assertEqual(response.status_code, 201)
        self.assertEqual(response.json(), {
            "codigo": "TPG1",
            "titulo": "Github",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 3,
            "versionProducto": 1
        })

    def test_create_ticket_without_client(self):
        # Given product and version
        payload = {
            "codigo": "string",
            "titulo": "string",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-20T21:15:51.375Z",
            "fechaCreacion": "2023-06-20T21:15:51.375Z",
            "versionProducto": 0
        }

        # When trying to create the ticket
        response = requests.post(f'{self.base_url}/tickets', json=payload)

        # Then the ticket is not created and client is requested
        self.assertEqual(response.status_code, 400)
        self.assertEqual(response.json(), {
            "message": ["Client is required"]
        })

    def test_create_ticket_without_version(self):
        # Given product and client
        payload = {
            "codigo": "string",
            "titulo": "string",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-20T21:15:51.375Z",
            "fechaCreacion": "2023-06-20T21:15:51.375Z",
            "cliente": 0
        }

        # When trying to create the ticket
        response = requests.post(f'{self.base_url}/tickets', json=payload)

        # Then ticket is not created and version is requested
        self.assertEqual(response.status_code, 400)
        self.assertEqual(response.json(), {
            "message": ["Version is required"]
        })

    def test_create_ticket_without_product(self):
        # Given client and version
        payload = {
            "codigo": "string",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-20T21:15:51.375Z",
            "fechaCreacion": "2023-06-20T21:15:51.375Z",
            "cliente": 0,
            "versionProducto": 0
        }

        # When trying to create the ticket
        response = requests.post(f'{self.base_url}/tickets', json=payload)

        # Then ticket is not created and product is requested
        self.assertEqual(response.status_code, 400)
        self.assertEqual(response.json(), {
            "message": ["Title is required"]
        })

if __name__ == '__main__':
    unittest.main()
