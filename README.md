# ODDIN (ORCHESTRATION DESIGNER DYNAMIC IVR NATIVE)

Proyecto desarrollado en IONIC (Angular) front-end el cual gestionarà los menus de un IVR auto ajustable

El proyecto tiene como alcance la configuración manual de las opciones de un IVR "Un IVR (INTERACTIVE RESPONSE UNIT) es un autómata que responde a una llamada e interactúa con el usuario mediante reconocimiento de voz o tonos. Las locuciones son grabadas previamente o procesadas en tiempo real a partir de un texto. Los IVR se emplean en servicios de atención al cliente."(Avaya, 2012) por medio de un aplicativo web o App 
 
El proyecto requiere dos pasos para completar su funcionalidad:
-	Por medio de la aplicación Web / App se crearán los menús en formato JSON; este archivo será reconstruido posteriormente.
-	Se configurará un proyecto ODD (ORCHESTRATION DESIGNER) para que lea el menú y reconstruya el flujo definido en el JSON
  
Tras finalizar el proyecto el usuario será capaz de configurar las opciones básicas de un IVR sin un acompañamiento técnico.

# Configuración de Entorno
## VS CODE
### keybindings.json
~~~json
// Place your key bindings in this file to override the defaults edit
[
    {
        "key": "ctrl+shift+numpad_subtract",
        "command": "workbench.action.closePanel",
    },
    {
        "key": "ctrl+shift+numpad_add",
        "command": "workbench.action.toggleMaximizedPanel",
    }
]
~~~