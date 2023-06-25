import unittest
import requests

class SwaggerAPITestCase(unittest.TestCase):

    def setUp(self):
        # Set up the base URL for your Swagger API
        self.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    
    def test_update_ticket_success(self):
        # Define the request payload
        payload = {
            "codigo": "string",
            "titulo": "string",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-20T20:46:07.087Z",
            "fechaCreacion": "2023-06-20T20:46:07.088Z",
            "cliente": 0,
            "versionProducto": 0
        }
        ticket_id = 1
        # Send the API request
        response = requests.put(f'{self.base_url}/ticket/{id}', json=payload)

        # Assert the response status code
        self.assertEqual(response.status_code, 200)

        # Assert the response message
        expected_response = "Actualización exitosa del ticket"
        self.assertEqual(response.json(), expected_response)

    def test_update_ticket_not_found(self):
        # Define the request payload
        payload = {
            "codigo": "string",
            "titulo": "string",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-20T20:46:07.087Z",
            "fechaCreacion": "2023-06-20T20:46:07.088Z",
            "cliente": 0,
            "versionProducto": 0
        }

        # Send the API request
        response = requests.put(f'{self.base_url}/ticket/nonexistent-id', json=payload)

        # Assert the response status code
        self.assertEqual(response.status_code, 404)


if __name__ == '__main__':
    unittest.main()
