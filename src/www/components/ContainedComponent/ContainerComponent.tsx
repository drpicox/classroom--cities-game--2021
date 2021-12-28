import { useMemo } from "react";
import { Section } from "www/theme/Section";
import { EntityList } from "www/screens/EntityScreen/EntityList";
import { useAppSelector } from "www/store/hooks";
import {
  makeCountProducingContaineds,
  makeGetAllContainedByEntityId,
} from "./selectors";

export function ContainerComponent({ entity }: any) {
  const getContaineds = useMemo(makeGetAllContainedByEntityId, []);
  const containeds = useAppSelector((s) =>
    getContaineds(s, { entityId: entity.id })
  );
  const countProducing = useMemo(makeCountProducingContaineds, []);
  const count = useAppSelector((s) =>
    countProducing(s, { entityId: entity.id })
  );

  if (!containeds.length) return null;

  return (
    <Section>
      Contents, producing:
      <span data-testid="producing-building-count">{count}</span>
      <EntityList entities={containeds} />
    </Section>
  );
}
