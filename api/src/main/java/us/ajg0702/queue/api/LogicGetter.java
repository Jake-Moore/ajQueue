package us.ajg0702.queue.api;

import us.ajg0702.utils.common.Config;

public interface LogicGetter {
    Logic constructLogic();
    AliasManager constructAliasManager(Config config);
}
