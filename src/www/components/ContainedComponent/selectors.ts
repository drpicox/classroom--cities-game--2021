import { createSelector } from "reselect";
import { makeGetAllGameEntities } from "www/store/game/selectors";

function getPropEntityId(state: any, { entityId }: { entityId: string }) {
  return entityId;
}

export function makeGetAllContainedByEntityId() {
  const getAllGameEntities = makeGetAllGameEntities();

  return createSelector(
    getAllGameEntities,
    getPropEntityId,
    (entities: any[], entityId: any) =>
      entities.filter((e) => e.containerId === entityId)
  );
}

export function makeCountProducingContaineds() {
  const getContaineds = makeGetAllContainedByEntityId();
  return createSelector(
    getContaineds,
    (containeds) => containeds.filter((x) => x.modifierRoundIncrement).length
  );
}
