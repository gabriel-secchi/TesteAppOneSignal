# Push notification com OneSignal

<img src="https://img.shields.io/github/last-commit/gabriel-secchi/TesteAppOneSignal" />
<img src="https://img.shields.io/snyk/vulnerabilities/github/gabriel-secchi/TesteAppOneSignal" />
<p>
<img src="https://img.shields.io/github/languages/top/gabriel-secchi/TesteAppOneSignal" />
<img src="https://img.shields.io/github/repo-size/gabriel-secchi/TesteAppOneSignal" />
</p>

## Descrição
Este é uma projeto de exemplo que visa fazer a integração com a olataforma [OneSignal](https://onesignal.com/) que serve como meio de envio de notificações.<br>
Neste exemplo é abordado somente as pushs notifications.

## Documentação
[OneSignal](https://documentation.onesignal.com/docs/android-sdk-setup)
[REST API](https://documentation.onesignal.com/reference/create-notification#formatting-filters)

### Ajustes do projeto
- Estou levando em consideração que você já leu a documentação e já pussui os projetos criados dentro do [Firebase](https://firebase.google.com/) e do [OnSignal](https://onesignal.com/).<br>
Para esse projeto funcionar corretamente basta você adicionar sua APP ID do OneSignal dentro das variáveis no arquivo **module build.grade**.
Neste local como o exmplo abaixo
```
buildTypes {
  release {
    minifyEnabled false
      proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
      buildConfigField("String", "ONESIGNAL_APP_ID", "\"YOU_APP_KEY\"")
    }
    debug {
      buildConfigField("String", "ONESIGNAL_APP_ID", "\"YOU_APP_KEY\"")
    }
}
```
