import unittest
import requests

class SwaggerAPITestCase(unittest.TestCase):
    def setUp(self):
        self.base_url = "https://tp-memo1-tribu-a-soporte.onrender.com"  # Replace with the actual base URL

    def test_create_ticket_with_product_version_and_client(self):
        # Given product, version, and client
        payload = {
            "codigo": "TPG1",
            "titulo": "Github",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-20T21:15:51.375+00:00",
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

    def test_get_ticket_info_by_id(self): 
        # Given a ticket id
        codigo = "TPG1"
        # When trying to get the ticket info
        response = requests.get(f'{self.base_url}/tickets/{codigo}')
        # Then ticket info is returned
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), {"codigo": "TPG1",
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


    def test_get_ticket_info_by_client(self) :
        # Given a client id
        cliente = 3
        # When trying to get the ticket info
        response = requests.get(f'{self.base_url}/cliente/{cliente}/tickets')
        # Then ticket info is returned
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(),   [
             {'cliente': 3,
            'codigo': 'TPG1',
            'description': 'string',
            'estado': 'PENDIENTE',
            'fechaCreacion': '2023-06-20T21:15:51.375+00:00',
            'fechaLimite': '2023-06-28T03:00:00.000+00:00',
            'prioridad': 'ALTA',
            'severidad': 'S1',
            'titulo': 'Github',
            'versionProducto': 1}])


    def test_get_ticket_by_versionProducto(self):  
        # Given a versionProducto id
        versionProducto = 1
        # When trying to get the ticket info
        response = requests.get(f'{self.base_url}/version-producto/{versionProducto}/tickets')
        # Then ticket info is returned
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), [{"codigo": "TPG1",
            "titulo": "Github",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 3,
            "versionProducto": 1
        }])

    


if __name__ == '__main__':
    unittest.main()
