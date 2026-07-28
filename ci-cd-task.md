Create a repo with a simple **Spring Boot (Maven)** project and implement a **GitHub Actions** pipeline with explicit **stages** (modeled via jobs + `needs`) that demonstrates: artifacts, security scanning, environment variables/secrets, and pushing an image to **GHCR** (no real deployment env).

## Stage 1 — Validate
**Job: validate**
- Runs on every **push** and **pull request**
- Set up Java
- Run a fast Maven check, e.g.:
  - `mvn -B -DskipTests=true validate` (or `compile`)

## Stage 2 — Build & Test (CI)
**Job: build_test**
- Runs on every push/PR
- Run:
  - `mvn -B test`
  - `mvn -B package`
- **Upload artifacts**:
  - JAR: `target/*.jar`
  - Test reports: `target/surefire-reports/**`

## Stage 3 — Security / Quality Gate (Dockerfile linting)
**Job: dockerfile_lint (Hadolint)**
- Runs on every push/PR
- Run **Hadolint** against the repo’s `Dockerfile`
- Pipeline must fail if Hadolint finds issues (this is the security/quality gate)

## Stage 4 — “Deploy” by publishing to GHCR
**Job: docker_publish_staging**
- Runs **only on pushes to `main`**
- Must depend on earlier stages: `needs: [build_test, dockerfile_lint]`
- **Download the JAR artifact** from Stage 2 (do not rebuild the JAR)
- Build and push Docker image to **GitHub Container Registry**
  - Example image: `ghcr.io/<org-or-user>/<repo>`
  - Tags required:
    - `:staging`
    - `:sha-<shortsha>` (traceability)

## Environment variables & secrets (required)
- Use **env vars** for non-sensitive config (examples: `REGISTRY=ghcr.io`, `IMAGE_NAME`, `JAVA_VERSION=17`)
- Use **secrets** for auth as needed:
  - Prefer `GITHUB_TOKEN` for pushing to GHCR in the same repo (no PAT needed)
- Don’t echo secrets in logs

## Deliverables
- pipeline script
- screenshots of working pipeline
- screenshot of env varialbes
- screenshots of container registry

