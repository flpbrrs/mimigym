# MimiGym 🏋️‍♂️🚧

> **Em construção.** Este projeto está em desenvolvimento ativo e ainda não possui uma versão utilizável. Esta página é atualizada conforme o progresso avança.

App Android de registro e acompanhamento de treinos de academia, com foco em **treino low volume** (o estilo de treino que mais tem me gerado adesão no último ano). Projeto pessoal, desenvolvido em paralelo ao estudo de Kotlin/Android, com o objetivo de aprender e de resolver uma necessidade real do meu dia a dia na academia.

## Por que esse app existe

Apps de treino, em geral, não diferenciam tipos de série de uma forma que funcione para mim — aquecimento, feeder e série de trabalho são tratados de forma praticamente equivalente, o que pode inflar o volume total e exigir cálculo manual de cargas a cada sessão. O MimiGym nasce **opinionado para low volume**:

- Diferencia warm-up, feeder e working set de acordo com a minha filosofia de treino;
- Calcula os feeders automaticamente a partir da carga alvo;
- Sugere a carga com base na última sessão do mesmo exercício;
- Prioriza interação mínima durante o treino (modo foco, uma série por vez).

## Como o app funciona

Dois modos de uso:

| Modo | Quando | Objetivo |
|---|---|---|
| **Planejamento** | Fora da academia | Montar templates de treino: exercícios, cargas alvo, substitutos |
| **Execução** | Durante o treino | Card mode, um exercício por vez, registro rápido de cargas/reps/RIR |

---

## Roadmap

Desenvolvimento em ritmo de hobby, sem prazos fechados — o macro abaixo deve mudar conforme o projeto evolui.

- 🎯 **Modo Execução** — usar o app de fato durante o treino na academia
- 📋 **Modo Planejamento** — montar e gerenciar templates de treino pela UI
- 📈 **Histórico e Progressão** — acompanhar evolução de carga ao longo do tempo

---

## Stack técnica

- **Linguagem:** Kotlin
- **UI:** Jetpack Compose + Material 3
- **Arquitetura:** Clean Architecture + MVVM
- **DI:** Koin
- **Persistência:** Room (SQLite) + DataStore
- **Navegação:** Navigation Compose (type-safe)

---

## Licença

Todos os direitos reservados — veja [LICENSE](LICENSE).
