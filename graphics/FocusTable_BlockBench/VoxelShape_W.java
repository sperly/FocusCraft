Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(4, 4, 1, 15, 14, 15),
Block.makeCuboidShape(1, 4, 7, 2, 7, 9),
Block.makeCuboidShape(1, 7, 9, 2, 8, 10),
Block.makeCuboidShape(1, 7, 6, 2, 8, 7),
Block.makeCuboidShape(1, 8, 10, 2, 10, 11),
Block.makeCuboidShape(1, 8, 5, 2, 10, 6)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});